package bit.data.service;

import bit.data.dao.UserDaoInter;
import bit.data.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInter {

    @Autowired
    UserDaoInter UserDao;

    @Override
    public int selectSearchId(String emailId) {
//        System.out.println(emailId);
        return UserDao.selectSearchId(emailId);
    }

    @Override
    public void insertUser(UserDto dto) {
        System.out.println("ser " + dto.getEmailId());
        UserDao.insertUser(dto);
    }

    @Override
    public List<String> selectSubstrSi() {
        return UserDao.selectSubstrSi();
    }

    /* @Override
    public int getIdPassCheck(String id, String pass) {
        Map<String, String> map = new HashMap<>();
        map.put("loginid", id);
        map.put("loginpass", pass);

        return userDao.getIdPassCheck(map);
    }

    @Override
    public UserDto getDataById(String id) {
        return userDao.getDataById(id);
    }

    @Override
    public UserDto getDataByNum(int num) {
        return userDao.getDataByNum(num);
    }

    @Override
    public void updatePhoto(int num, String photo) {
        Map<String, Object> map = new HashMap<>();
        map.put("num", num);
        map.put("photo", photo);

        userDao.updatePhoto(map);
    }

    @Override
    public void updateuser(UserDto dto) {
        userDao.updateuser(dto);
    }

    @Override
    public void deleteuser(int num) {
        userDao.deleteuser(num);
        ;
    }

    @Override
    public int getTotalCount() {
        return userDao.getTotalCount();
    }

    @Override
    public List<UserDto> getAllusers() {
        return userDao.getAllusers();
    }

    @Override
    public void insertuser(UserDto dto) {
        userDao.insertuser(dto);
    }

    @Override
    public int getSearchId(String id) {
        return userDao.getSearchId(id);
    }

    @Override
    public String getName(String id) {
        return userDao.getName(id);
    }*/

}
