package com.sagarandcompany.linkSharing.repository.ReadingItemRepository;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.ReadingItemDTO;
import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ReadingItemImpl implements ReadingItemRepo {
    @Autowired
    private SessionFactory sessionFactory;

    public ReadingItem save(ReadingItemDTO readingItemDTO) {
        ReadingItem readingItem = new ReadingItem();
        Session session = getSession();
        User user = session.get(User.class, User.getLoginUser().getUser_id());
        Resource resource = session.get(Resource.class, readingItemDTO.getResource_id());
        readingItem.setResource(resource);
        readingItem.setUser(user);
        readingItem.setRead(readingItemDTO.isIs_read());

        List<ReadingItem> readingItems = user.getReadingitems();
        readingItems.add(readingItem);

        session.save(user);
        return readingItem;
    }

    public ReadingItem get(Long id) {
        if (id != null) {
            ReadingItem readingItem = getSession().get(ReadingItem.class, id);
            if (readingItem != null) {
                return readingItem;
            } else
                return null;
        } else
            return null;
    }


    public Boolean delete(Long id) {
        Session session = getSession();
        ReadingItem readingItem = session.get(ReadingItem.class, id);
        session.delete(readingItem);
        return true;
    }

    public Boolean deleteByResource(Resource resource) {
        Session session = getSession();

        Criteria criteria = session.createCriteria(ReadingItem.class);
        criteria.createAlias("resource", "r");
        criteria.createAlias("user", "u");

        criteria.add(Restrictions.eq("r.resource_id", resource.getResource_id()));
        criteria.add(Restrictions.eq("u.user_id", User.getLoginUser().getUser_id()));
        criteria.setMaxResults(1);
        ReadingItem readingItem = (ReadingItem) criteria.uniqueResult();

        if (readingItem != null) {
            SQLQuery sqlQuery = session.createSQLQuery("delete from user_reading_item where reading_item_id=" + readingItem.getReading_item_id() + " and user_id=" + User.getLoginUser().getUser_id());
            sqlQuery.executeUpdate();
            session.delete(readingItem);
            session.flush();
            return true;
        }
        return false;
    }

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        return session;
    }


}
