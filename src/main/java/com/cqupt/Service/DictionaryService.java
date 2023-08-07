package com.cqupt.Service;

import com.cqupt.entity.Dictionary;
import java.util.List;

public interface DictionaryService {
    List<Dictionary> listByTypeAndPid(String userType, Integer pid);
}
