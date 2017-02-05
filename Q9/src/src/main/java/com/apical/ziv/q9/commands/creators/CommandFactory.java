/**
 * CommandFactory.java
 */
package com.apical.ziv.q9.commands.creators;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Command;
import com.apical.ziv.q9.interfaces.Creatable;

/**
 * @author ziv
 *
 */
@Component
public class CommandFactory {

	@Autowired
	private List<AbstractCommandCreator> creators;

	@PostConstruct
	public void sort() {
		if (CollectionUtils.isNotEmpty(creators)) {
			Collections.sort(creators, Creatable.comparator);
		}
	}

	public Command create(String line) throws ShapeCreateException {
		if (StringUtils.isEmpty(line)) {
			return null;
		}

		if (CollectionUtils.isEmpty(creators)) {
			return null;
		}

		for (AbstractCommandCreator creator : creators) {
			if (creator.isSupport(line)) {
				return creator.create(line);
			}
		}

		return null;
	}

}
