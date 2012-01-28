package im.lich.framework.core.base.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.IMutableSearch;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchUtil;

public class FrameworkUtils {
    
	/**
	 * From a Map of request parameters, return a list of the parameters that
	 * are valid and relevant to search. These include "sort", "page",
	 * "pagesize", "f-...", and "fo-...". Each result is returned as an array of
	 * two strings; the first is the parameter name, and the second is the
	 * value.
	 */
	public static List<String[]> filterSearchParams(Map<String, String[]> params, boolean includeSorts,
			boolean includeFilters, boolean includePaging) {
		List<String[]> results = new ArrayList<String[]>();

		// Sorts
		if (includeSorts) {
			String[] sorts = params.get("sort");
			if (sorts != null) {
				for (String sort : sorts) {
					if (sort != null && !sort.equals("")) {
						results.add(new String[] { "sort", sort });
					}
				}
			}
		}

		// Filters
		if (includeFilters) {
			for (Map.Entry<String, String[]> param : params.entrySet()) {
				String name = param.getKey();
				if (name.startsWith("f-") && name.length() > 2) {
					String value = param.getValue()[0];
					if (value != null && value.length() > 0) {
						results.add(new String[] { param.getKey(), param.getValue()[0] });
						String opString = "fo-" + param.getKey().substring(2);
						String[] op = params.get(opString);
						if (op != null && !"".equals(op[0])) {
							results.add(new String[] { opString, op[0] });
						}
					}
				}
			}
		}

		// Paging
		if (true) {
			String[] values = params.get("page");
			if (values != null && !"".equals(values[0])) {
				try {
					Integer.parseInt(values[0]);
					results.add(new String[] { "page", values[0] });
				} catch (NumberFormatException ex) {
					// don't add it
				}
			}
			values = params.get("pagesize");
			if (values != null && !"".equals(values[0])) {
				try {
					Integer.parseInt(values[0]);
					results.add(new String[] { "pagesize", values[0] });
				} catch (NumberFormatException ex) {
					// don't add it
				}
			}
		}

		return results;
	}

	public static ISearch getSearchFromParams(Map<String, String[]> params) {
		return getSearchFromParams(null, params);
	}

	/**
	 * Construct a search object based on a Map or request parameters. These
	 * parameters are considered...
	 * <ul>
	 * <li>sort - a property on which to sort. If the value is preceded by an
	 * "!", the sort will be descending. (ex: sort=name, sort=!name)
	 * <li>page - the 1-based page number. (ex: page=1)
	 * <li>pagesize - maxResults for the search. (ex: pagesize=10)
	 * <li>f-... - a filter. The param name includes the property and the value
	 * is the value for the filter. The default operator is ILIKE (with %
	 * appended, so it's really "starts with..."). Another parameter can be
	 * specified with another parameter starting with "fo-". (ex: f-name=Bob,
	 * f-city.name=Chi, f-population=100&fo-population=5 [note that 5 is
	 * OP_GREATER_OR_EQUAL])
	 * </ul>
	 * 
	 * @param search
	 *            - if not null, the search options will be added to the given
	 *            search object.
	 */
	public static ISearch getSearchFromParams(IMutableSearch search, Map<String, String[]> params) {
		List<String[]> paramList = filterSearchParams(params, true, true, true);

		for (String[] param : paramList) {
			String name = param[0];
			String value = param[1];
			// Sorts
			if ("sort".equals(name)) {
				if (search == null)
					search = new Search();
				if (value.startsWith("!")) {
					SearchUtil.addSortDesc(search, value.substring(1));
				} else {
					SearchUtil.addSortAsc(search, value);
				}
			} else if ("page".equals(name)) {
				if (search == null)
					search = new Search();
				search.setPage(Integer.parseInt(value) - 1);
			} else if ("pagesize".equals(name)) {
				if (search == null)
					search = new Search();
				search.setMaxResults(Integer.parseInt(value));
			} else if (name.startsWith("f-")) {
				if (search == null)
					search = new Search();
				int op = -1;
				String opString = "fo-" + name.substring(2);
				for (String[] p2 : paramList) {
					if (p2[0].equals(opString)) {
						op = Integer.parseInt(p2[1]);
						break;
					}
				}
				if (op == -1) {
					SearchUtil.addFilterILike(search, name.substring(2), value + "%");
				} else {
					SearchUtil.addFilter(search, new Filter(name.substring(2), value, op));
				}
			}
		}

		return search;
	}
}
