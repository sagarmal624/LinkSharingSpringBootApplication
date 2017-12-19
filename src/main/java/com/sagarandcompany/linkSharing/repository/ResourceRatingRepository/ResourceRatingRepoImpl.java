package com.sagarandcompany.linkSharing.repository.ResourceRatingRepository;

import com.sagarandcompany.linkSharing.domains.ResourceRating;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
   public class ResourceRatingRepoImpl  implements ResorceRatingRepo{

    @Autowired
   private  SessionFactory sessionFactory;


    public ResourceRating save(ResourceRating resorcerating)
      {
          getSession().save(resorcerating);
          if (resorcerating.getResource_rating_id() != null)
              return resorcerating;
          else
              return null;

      }




      private Session getSession()
      {
         Session session= sessionFactory.getCurrentSession();
         return session;
      }
}
