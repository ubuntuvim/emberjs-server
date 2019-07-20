package com.emberjs.server.domain.repository;

import com.emberjs.server.domain.model.Notebook;

import io.katharsis.queryspec.QuerySpec;
import io.katharsis.repository.ResourceRepositoryV2;
import io.katharsis.resource.links.PagedLinksInformation;
import io.katharsis.resource.list.ResourceList;
import io.katharsis.resource.list.ResourceListBase;
import io.katharsis.resource.meta.PagedMetaInformation;

/**
 * notebook实体相关操作接口
 * @author ubuntuvim
 *
 */
public interface NotebookRepository extends ResourceRepositoryV2<Notebook, String> {

	/**
	 * 对应JsonApi规范里面的meta属性
	 * @author ubuntuvim
	 *
	 */
	public class NotebookListMeta implements PagedMetaInformation {

		private Long totalResourceCount;

		@Override
		public Long getTotalResourceCount() {
			return totalResourceCount;
		}

		@Override
		public void setTotalResourceCount(Long totalResourceCount) {
			this.totalResourceCount = totalResourceCount;
		}
	}
	
	/**
	 * 对应JsonApi规范里面的Links属性
	 * @author ubuntuvim
	 *
	 */
	public class NotebookListLinks implements PagedLinksInformation {

		private String first;

		private String last;

		private String next;

		private String prev;

		@Override
		public String getFirst() {
			return first;
		}

		@Override
		public void setFirst(String first) {
			this.first = first;
		}

		@Override
		public String getLast() {
			return last;
		}

		@Override
		public void setLast(String last) {
			this.last = last;
		}

		@Override
		public String getNext() {
			return next;
		}

		@Override
		public void setNext(String next) {
			this.next = next;
		}

		@Override
		public String getPrev() {
			return prev;
		}

		@Override
		public void setPrev(String prev) {
			this.prev = prev;
		}
	}
	
	public class NotebookList extends ResourceListBase<Notebook, NotebookListMeta, NotebookListLinks> {
		
	}

	@Override
	public ResourceList<Notebook> findAll(QuerySpec querySpec);
	
}
