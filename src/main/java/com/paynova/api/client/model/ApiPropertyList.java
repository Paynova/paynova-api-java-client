package com.paynova.api.client.model;

import java.util.ArrayList;
import java.util.Collection;


public class ApiPropertyList<T extends ApiProperty> extends ArrayList<T>{

	private static final long serialVersionUID = -7497453927005801961L;

	public ApiPropertyList() {
		
	}
	
	/**
	 * Class constructor.
	 * Used the collection coll to create the current ApiPropertyList
	 * @param coll
	 */
	public ApiPropertyList(Collection<T> coll) {
		addAll(coll);
	}

}
