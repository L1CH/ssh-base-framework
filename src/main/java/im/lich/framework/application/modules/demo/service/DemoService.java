package im.lich.framework.application.modules.demo.service;

import im.lich.framework.application.modules.demo.model.Demo;

import java.util.List;

import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;

/**
 * @author ethan
 */
public interface DemoService {
	
	/**
	 * 增加或更新demo
	 * @param demo
	 * @return
	 */
	public boolean save(Demo demo);

	/**
	 * 批量增加或更新demo
	 * @param demo
	 * @return
	 */
	public boolean[] save(Demo[] demos);

	/**
	 * 删除demo
	 * @param demo
	 * @return
	 */
	public boolean remove(Demo demo);

	/**
	 * 批量删除demo
	 * @param demos
	 */
	public void remove(Demo[] demos);

	/**
	 * 根据主键删除demo
	 * @param id
	 * @return
	 */
	public boolean removeById(Integer id);

	/**
	 * 批量根据主键删除demo
	 * @param ids
	 */
	public void removeByIds(String[] ids);

	/**
	 * 查询demo数据记录集
	 * @return
	 */
	public List<Demo> findAll();

	/**
	 * 根据主键查询demo
	 * @param id
	 * @return
	 */
	public Demo findById(Integer id);

	/**
	 * 批量根据主键查询demo记录集
	 * @param ids
	 * @return
	 */
	public Demo[] findByIds(Integer[] ids);
	
	/**
	 * 根据条件查询demo记录集
	 * @param search
	 * @return
	 */
	public List<Demo> search(ISearch search);
	
	/**
	 * 根据条件查询demo记录集总数
	 * @param search
	 * @return
	 */
    public int count(ISearch search);
    
    /**
     * 根据条件查询demo集合与总数
     * @param search
     * @return
     */
    public SearchResult<Demo> searchAndCount(ISearch search);
    
	/**
	 * 根据条件查询demo主键ID
	 * @param search
	 * @return
	 */
	public Integer searchUnique(ISearch search);
    
	/**
	 * 持久化session数据到数据库
	 */
	public void flush();
}
