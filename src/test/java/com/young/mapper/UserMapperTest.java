package com.young.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.young.entity.UserEntity;
import com.young.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity("张龙"));
		UserMapper.insert(new UserEntity("周一"));
		UserMapper.insert(new UserEntity("袁玲"));

		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.getAll();
		System.out.println(users.toString());
	}

	@Test
	public void testGetOne() throws Exception {
		UserEntity userEntity = UserMapper.getOne(1);
		System.out.println(userEntity.toString());
	}
	
	
	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(1);
		System.out.println(user.toString());
		user.setName("孔杰");
		UserMapper.update(user);
		Assert.assertTrue(("孔杰".equals(UserMapper.getOne(1).getName())));
	}

}