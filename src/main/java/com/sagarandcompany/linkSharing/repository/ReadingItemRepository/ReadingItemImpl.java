package com.sagarandcompany.linkSharing.repository.ReadingItemRepository;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.domains.Resource;
import com.sagarandcompany.linkSharing.domains.User;
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

    public ReadingItem save (ReadingItem readingItem) {
        User user = getSession().get(User.class, User.getLoginUser().getUser_id());
        Resource resource = getSession().get(Resource.class, readingItem.getResource().getResource_id());
        readingItem.setUser(user);
        readingItem.setResource(resource);

        /*List<ReadingItem> readingitems=user.getReadingitems();
        if(readingitems==null)
        {
            readingitems =new ArrayList<>();

        }

        readingitems.add(readingItem);
        getSession().saveOrUpdate(resource);
        return readingItem;
    }
*/

       ReadingItem readngitem= (ReadingItem) getSession().save(readingItem);
        if(readngitem.getReading_item_id()!=null)
        {
            return readingItem;
        }
        else
        {
            return null;
        }

    }
    private Session getSession()
    {

        Session session=sessionFactory.getCurrentSession();
        return session;
    }


}
