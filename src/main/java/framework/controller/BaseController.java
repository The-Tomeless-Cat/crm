package framework.controller;

import javax.servlet.http.HttpServlet;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import com.dao.system.KbmMapper;
import com.dao.system.MenuMapper;
import com.dao.system.RoleMapper;
import com.dao.system.RoleMenuMapper;
import com.dao.system.UserMapper;
import com.dao.system.UserRoleMapper;
import com.service.system.KbmService;

import com.service.other.FeedbackService;
import com.service.other.PriceListService;
import com.service.system.ActivityProductService;

import com.service.system.ActivityService;
import com.service.system.AfterSalesService;
import com.service.system.MenuService;
import com.service.system.ProductCollectService;

import com.service.system.ProductService;
import com.service.system.OrderService;

import com.service.system.RoleMenuService;
import com.service.system.RoleService;
import com.service.system.UserMsgService;
import com.service.system.UserRoleService;
import com.service.system.UserService;
public class BaseController extends HttpServlet {
	@Autowired
	public UserMsgService userMsgService;
	@Autowired
	public UserService userService;
	@Autowired
	public RoleService roleService;
	@Autowired
	public MenuService menuService;
	@Autowired
	public UserRoleService userRoleService;
	@Autowired
	public RoleMenuService roleMenuService;
	@Autowired
	public KbmService kbmService;
	@Autowired
	public UserMapper userMapper;
	@Autowired
	public KbmMapper kbmMapper;
	@Autowired
	public RoleMapper roleMapper;
	@Autowired
	public MenuMapper menuMapper;
	@Autowired
	public UserRoleMapper userRoleMapper;
	@Autowired
	public RoleMenuMapper roleMenuMapper;
	@Autowired
	public UserRoleService userroleService;
	@Autowired
	public OrderService orderService;
	@Autowired
	public ActivityService activityService;
	@Autowired
	public FeedbackService feedbackService;
	@Autowired
	 public ProductCollectService productCollectService;
	@Autowired
	public ProductService productService;
	@Autowired
	public ActivityProductService activityProductService;
	@Autowired
	public AfterSalesService afterSalesService;
	@Autowired
	public  PriceListService  priceListService;

	/**
	 * 
	 */
	private static final long serialVersionUID = -3412511940987849417L;

	@InitBinder
	public void initBinder(ServletRequestDataBinder servletRequestDataBinder) {
		servletRequestDataBinder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
}
