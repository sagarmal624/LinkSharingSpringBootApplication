package com.sagarandcompany.linkSharing.repository.ReadingItemRepository;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReadingItemImpl implements ReadingItemRepo {
    @Autowired
    private SessionFactory sessionFactory;

    public ReadingItem save (ReadingItem readingItem)
    {
        ReadingItem rdngitem= (ReadingItem) getSession().save(readingItem);
        if(rdngitem.getReading_item_id()!=null)
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
