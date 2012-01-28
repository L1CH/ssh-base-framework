package im.lich.framework.application.modules.demo.action;

import im.lich.framework.application.modules.demo.model.Demo;
import im.lich.framework.application.modules.demo.service.DemoService;
import im.lich.framework.core.base.test.BaseTestTemplate;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;

/**
 * @author ethan
 */
public class DemoActionTest extends BaseTestTemplate {

	@Resource
	private DemoService demoService;

	@Before
	public void setUp() throws Exception {
		System.out.println("测试开始");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("测试结束");
	}

	@BeforeTransaction
	public void beforeTransaction() {
		System.out.println("事务开始");
	}

	@AfterTransaction
	public void afterTransaction() {
		System.out.println("事务结束");
	}

	@Test
	public void testInsert() {
		Demo demo = new Demo();
		demo.setTitle("junit-testing");
		demo.setContent("junit-content");
		demo.setPublishdate(new Date());
		demoService.save(demo);
	}

	@Test
	public void testInsertMore() {
		Demo[] demos = new Demo[10];
		for (int i = 0; i < 10; i++) {
			Demo demo = new Demo();
			demo.setTitle("junit-testing" + i);
			demo.setContent("junit-content" + i);
			demo.setPublishdate(new Date());
			demos[i] = demo;
		}
		demoService.save(demos);
	}

	@Test
	public void testFindAll() {
		List<Demo> list = demoService.findAll();
		for (Demo demo : list) {
			System.out.println(demo.getTitle());
		}
	}

	@Test
	public void testSearch() {
		Search search = new Search();
		search.addFilterEqual("title", "junit-testing");
		List<Demo> list = demoService.search(search);
		for (Demo demo : list) {
			System.out.println(demo.getTitle());
		}
	}

	@Test
	public void testSearchCount() {
		Search search = new Search();
		search.addFilterEqual("title", "junit-testing");
		int count = demoService.count(search);
		System.out.println(count);
	}

	@Test
	public void testSearchAndCount() {
		Search search = new Search();
		search.addFilterEqual("title", "junit-testing");
		SearchResult<Demo> result = demoService.searchAndCount(search);
		List<Demo> list = result.getResult();
		for (Demo demo : list) {
			System.out.println(demo.getTitle());
		}
		int count = result.getTotalCount();
		System.out.println(count);
	}

	@Test
	public void testSearchInterface() {
		Search search = new Search();
		// 每页记录数
		search.setMaxResults(17);
		// 当前页码
		search.setPage(3);

		// 根据条件查询当前页码记录集
		List<Demo> list = demoService.search(search);
		for (Demo demo : list) {
			System.out.println(demo.getTitle());
		}

		// 根据条件查询记录集总数
		int totalResults = demoService.count(search);
		System.out.println(totalResults);

		// 根据条件查询记录集及总记录数
		SearchResult<Demo> result = demoService.searchAndCount(search);
		list = result.getResult();
		for (Demo demo : list) {
			System.out.println(demo.getTitle());
		}
		totalResults = result.getTotalCount();
		System.out.println(totalResults);
	}
}
