package sweng.action;

import sweng.bean.TestActiveProfile;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: swengcode
 * @Date: 2020/1/318:31
 */
public class firstAction extends ActionSupport {

    private String name;
    private String password;
    private TestActiveProfile profile;
    private List<TestActiveProfile> profiles;

    public firstAction() {
    }

    public firstAction(TestActiveProfile profile) {
        this.profile = profile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TestActiveProfile getProfile() {
        return profile;
    }

    public void setProfile(TestActiveProfile profile) {
        this.profile = profile;
    }

    public List<TestActiveProfile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<TestActiveProfile> profiles) {
        this.profiles = profiles;
    }

    @Override
    public String execute() throws Exception {


        System.out.println("--- bean init ---");
        System.out.println(profile.getName());


        profiles = new ArrayList<TestActiveProfile>();
        TestActiveProfile profile1 = new TestActiveProfile();
        profile1.setName("pro1");
        TestActiveProfile profile2 = new TestActiveProfile();
        profile2.setName("pro2");
        TestActiveProfile profile3 = new TestActiveProfile();
        profile3.setName("pro3");

        profiles.add(profile1);
        profiles.add(profile2);
        profiles.add(profile3);

        System.out.println("整合");
       // System.out.println(this.profile.getName());
       // System.out.println(this.name+"-"+this.password);

        return SUCCESS;
    }
}
