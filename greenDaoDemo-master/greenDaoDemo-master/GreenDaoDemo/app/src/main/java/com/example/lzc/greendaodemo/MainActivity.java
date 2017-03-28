package com.example.lzc.greendaodemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.lzc.greendaodemo.adapter.ListViewAdapter;
import com.example.lzc.greendaodemo.dao.GreenDaoManager;
import com.example.lzc.greendaodemo.dao.User;
import com.example.lzc.greendaodemo.dao.userdao.UserDao;

import java.util.ArrayList;
import java.util.List;




/**
 * 类描述：测试类
 * 创建人：zz
 * 创建时间：2017/2/14 10:53
 */
public class MainActivity extends Activity implements View.OnClickListener{

    private Button buttonAdd;
    private Button buttonDelete;
    private Button buttonUpdate;
    private Button buttonSelect;
    private ListView listViewId;
    private ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化UI
     */
    private void initView() {
        buttonAdd = ((Button) findViewById(R.id.button_add));
        buttonAdd.setOnClickListener(this);
        buttonDelete = ((Button) findViewById(R.id.button_delete));
        buttonDelete.setOnClickListener(this);
        buttonUpdate = ((Button) findViewById(R.id.button_update));
        buttonUpdate.setOnClickListener(this);
        buttonSelect = ((Button) findViewById(R.id.button_select));
        buttonSelect.setOnClickListener(this);
        listViewId = ((ListView) findViewById(R.id.listview_id));
        adapter = new ListViewAdapter(new ArrayList<User>(),getApplicationContext());
        listViewId.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        UserDao userDao = GreenDaoManager.getInstance().getNewSession().getUserDao();
        switch (v.getId()){
            case R.id.button_add:
                for (int i = 0; i < 10; i++) {
                    User user = new User();
                    user.setName("张"+i);
                    user.setPassWord("123456");
                    user.setSex("男");
                    userDao.insert(user);
                }
                break;
            case R.id.button_delete:
               // userDao.deleteAll();      删除所有的
                //删除张2
                User userSecond = userDao.queryBuilder().where(UserDao.Properties.Name.eq("张2")).build().unique();
                userDao.deleteByKey(userSecond.getId());
                break;
            case R.id.button_update:
                List<User> searchUser = userDao.queryBuilder().where(UserDao.Properties.Name.eq("张4")).build().list();
                for (int i = 0; i < searchUser.size(); i++) {
                    User user = searchUser.get(i);
                    user.setName("张5");
                    userDao.update(user);
                }

                break;
            case R.id.button_select:
                adapter.clear();
                List<User> users = userDao.loadAll();
                adapter.addAll(users);
                break;

        }
    }
}
