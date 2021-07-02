package sweng.service;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/1017:09
 */
public interface SupportMountTypeAware {

    public Map<String, String> supportedMountTypesWithAlias(); // alias->mount type.

    public List<String> supportedMountTypes();

}
