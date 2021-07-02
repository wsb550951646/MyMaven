package sweng.serviceImp;

import sweng.service.SupportMountTypeAware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/4/1018:22
 */
public class SupportMountTypeAwareImp implements SupportMountTypeAware {

    private Map<String,String> supportMountTypeWithAlias = new HashMap<>();
    private List<String> realMountTypes = new ArrayList<>();

    private String supportMountTypes = "";

    public String getSupportMountTypes() {
        return supportMountTypes;
    }

    public void setSupportMountTypes(String supportMountTypes) {
        this.supportMountTypes = supportMountTypes;
    }

    public Map<String, String> getSupportMountTypeWithAlias() {
        return supportMountTypeWithAlias;
    }

    public void setSupportMountTypeWithAlias(Map<String, String> supportMountTypeWithAlias) {
        this.supportMountTypeWithAlias = supportMountTypeWithAlias;
    }

    public List<String> getRealMountTypes() {
        return realMountTypes;
    }

    public void setRealMountTypes(List<String> realMountTypes) {
        this.realMountTypes = realMountTypes;
    }

    public void init(){

        for(String each : supportMountTypes.split(",")){
            String[] data = each.split(":");
            if(data.length>1){
                String alias = data[0];
                String realType = data[1];
                supportMountTypeWithAlias.put(alias,realType);
            }else {
                String realType = data[0];
                realMountTypes.add(data[0]);
                supportMountTypeWithAlias.put(realType, realType);
            }
        }
    }

    @Override
    public Map<String, String> supportedMountTypesWithAlias() {
        return supportMountTypeWithAlias;
    }

    @Override
    public List<String> supportedMountTypes() {
        return realMountTypes;
    }
}
