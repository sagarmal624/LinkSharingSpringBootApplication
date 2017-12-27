package com.sagarandcompany.linkSharing.repository.ReadingItemRepository;

import com.sagarandcompany.linkSharing.domains.ReadingItem;
import com.sagarandcompany.linkSharing.utility.ReadingItemDTO;

public interface ReadingItemRepo {
    public ReadingItem save (ReadingItemDTO readingItemDTO) ;
}
