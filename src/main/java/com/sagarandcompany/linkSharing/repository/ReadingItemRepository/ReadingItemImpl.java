package com.sagarandcompany.linkSharing.repository.ReadingItemRepository;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.User;
import com.sagarandcompany.linkSharing.utility.ReadingItemDTO;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.stylesheets.LinkStyle;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
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

    private Session getSession() {

        Session session = sessionFactory.getCurrentSession();
        return session;
    }


}
