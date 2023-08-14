package com.cqupt.Service;

import com.cqupt.pojo.Entity.Dictionary;
import java.util.List;

public interface DictionaryService {
    List<Dictionary> listByTypeAndPid(String userType, Integer pid);
}
