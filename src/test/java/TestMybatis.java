import com.itcast.oa.base.util.Sequence;
import com.itcast.oa.dao.IRolePrivilegeDAO;
import com.itcast.oa.domain.Department;
import com.itcast.oa.domain.Privilege;
import com.itcast.oa.domain.Role;
import com.itcast.oa.domain.RolePrivilege;
import com.itcast.oa.service.*;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by ichoice on 2017/2/17.
 */

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:config/applicationContext-mybatis.xml"})

public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);
    private ApplicationContext ac = null;
    @Resource
    private IPersonService personService = null;

    @Autowired
    private IDepartmentService departmentService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private IPrivilegeService privilegeService;

    @Autowired
    private IRolePrivilegeDAO rolePrivilegeDAO;

//  @Before
//  public void before() {
//      ac = new ClassPathXmlApplicationContext("applicationContext.xml");
//      userService = (IUserService) ac.getBean("userService");
//  }

    @Test
    public void test1() {
//        Person person=personService.get(Long.valueOf("1"));
//        System.out.println(person.getId());
//        System.out.println("值："+person.getName());
//        logger.info("值："+person.getName());
//        logger.info(JSON.toJSONString(person));
//        List<Department> departments=departmentService.getAll();
//        System.out.println(departments.size());
//        System.out.println(departments.get(0).getId());
//        Department department=new Department();
//        department.setId(Long.valueOf(Sequence.nextId()));
//        department.setName("三级部门");
//        department.setDescription("三级部门");
//        departmentService.create(department);
//        User user =new User();
//        user.setId(Long.valueOf(Sequence.nextId()));
//        user.setLoginname("admin");
//        user.setName("管理员");
//        user.setPassword("123456");
//        user.setRoleId("1");
//        userService.insert(user);
    }

    @Test
    public void testRole(){
        Role role=new Role();
        role.setId(Long.valueOf(Sequence.nextId()));
        role.setName("topAdmin");
        role.setDescription("顶级管理员");
        roleService.save(role);
    }

    @Test
    public void testDepartment(){
        Date date=new Date();
         /*顶级部门级部门*/
        Department dept = new Department();
        dept.setId(Long.valueOf(Sequence.nextId()));
        dept.setName("司令部");
        dept.setCreateTime(date);
        dept.setUpdateTime(date);
        departmentService.save(dept);

        /*一级部门*/
//        Department dept_1 = new Department();
//        dept_1.setId(Long.valueOf(Sequence.nextId()));
//        dept_1.setName("市场部");
//        dept_1.setCreateTime(date);
//        dept_1.setUpdateTime(date);
//
//        Department dept_2 = new Department();
//        dept_2.setId(Long.valueOf(Sequence.nextId()));
//        dept_2.setName("开发部");
//        dept_2.setCreateTime(date);
//        dept_2.setUpdateTime(date);
//
//        /*二级部门*/
//        Department dept_1_1 = new Department();
//        dept_1_1.setId(Long.valueOf(Sequence.nextId()));
//        dept_1_1.setName("宣传部");
//        dept_1_1.setParentid(dept_1.getId());
//        dept_1_1.setCreateTime(date);
//        dept_1_1.setUpdateTime(date);
//
//        Department dept_1_2 = new Department();
//        dept_1_2.setId(Long.valueOf(Sequence.nextId()));
//        dept_1_2.setName("业务部");
//        dept_1_2.setParentid(dept_1.getId());
//        dept_1_2.setCreateTime(date);
//        dept_1_2.setUpdateTime(date);
//
//        Department dept_2_1 = new Department();
//        dept_2_1.setId(Long.valueOf(Sequence.nextId()));
//        dept_2_1.setName("开发一部");
//        dept_2_1.setParentid(dept_2.getId());
//        dept_2_1.setCreateTime(date);
//        dept_2_1.setUpdateTime(date);
//
//        Department dept_2_2 = new Department();
//        dept_2_2.setId(Long.valueOf(Sequence.nextId()));
//        dept_2_2.setName("开发二部");
//        dept_2_2.setParentid(dept_2.getId());
//        dept_2_2.setCreateTime(date);
//        dept_2_2.setUpdateTime(date);
//
//         /*三级部门*/
//        Department dept_1_2_1 = new Department();
//        dept_1_2_1.setId(Long.valueOf(Sequence.nextId()));
//        dept_1_2_1.setName("业务一部");
//        dept_1_2_1.setParentid(dept_1_2.getId());
//        dept_1_2_1.setCreateTime(date);
//        dept_1_2_1.setUpdateTime(date);
//
//        Department dept_1_2_2 = new Department();
//        dept_1_2_2.setId(Long.valueOf(Sequence.nextId()));
//        dept_1_2_2.setName("业务二部");
//        dept_1_2_2.setParentid(dept_1_2.getId());
//        dept_1_2_2.setCreateTime(date);
//        dept_1_2_2.setUpdateTime(date);
//
//        departmentService.insert(dept_1);
//        departmentService.insert(dept_1_1);
//        departmentService.insert(dept_1_2);
//        departmentService.insert(dept_1_2_1);
//        departmentService.insert(dept_1_2_2);
//        departmentService.insert(dept_2);
//        departmentService.insert(dept_2_1);
//        departmentService.insert(dept_2_2);
    }

    @Test
    @Rollback(false)
    public void testUser(){
//        User user =userService.getById(Long.valueOf("1489646932206000"));
//        user.setLoginname("admin");
//        user.setName("管理员");
//        user.setPassword("123456");
//        user.setDepartmentid(Long.valueOf("1490059731281000"));
//        Role role=roleService.getById(Long.valueOf("1489647606645000"));
//        user.setRoleid(role.getId().toString());
//        userService.update(user);
        int count=userService.getByLoginName("admin");
        System.out.println(count);
    }

    @Test
    @Rollback(false)
    public void testPrivilege(){
//        List<Privilege> privileges=privilegeService.getTopPrivilege();
//        System.out.print(privileges.size());
//        for (int i=1;i<20;i++){
//            Privilege privilege=privilegeService.getById(Long.valueOf(i));
//            privilege.setId(Long.valueOf(Sequence.nextId()));
//            privilegeService.save(privilege);
//        }
//        List<Privilege> privileges=privilegeService.getPrivilegesByRoleId(Long.valueOf("1489647606645000"));
//        System.out.print(privileges.size());
        List<Privilege> privileges=privilegeService.getAllPrivilege();
        System.out.print(privileges.size());
    }

    @Test
    public void testRolePrivilege(){
        RolePrivilege rolePrivilege=new RolePrivilege();
        rolePrivilege.setId(Long.valueOf(Sequence.nextId()));
        rolePrivilege.setRoleId(Long.valueOf("1489647606645000"));
        rolePrivilege.setPrivilegeId(Long.valueOf("1490081525799000"));
        rolePrivilegeDAO.save(rolePrivilege);
    }
}
