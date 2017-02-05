/**
 * ShapeFactory.java
 */
package com.apical.ziv.q9.shapes.creators;

import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.apical.ziv.q9.exceptions.ShapeCreateException;
import com.apical.ziv.q9.interfaces.Creatable;
import com.apical.ziv.q9.interfaces.Shape;
import com.apical.ziv.q9.shapes.ClosedShape;

/**
 * @author ziv
 *
 */
@Component
public class ShapeFactory {

	@Autowired
	private List<AbstractShapeCreator> creators;

	@PostConstruct
	public void sort() {
		if (CollectionUtils.isNotEmpty(creators)) {
			Collections.sort(creators, Creatable.comparator);
		}
	}

	public Shape create(String line) throws ShapeCreateException {
		if (StringUtils.isEmpty(line)) {
			return null;
		}

		if (CollectionUtils.isEmpty(creators)) {
			return null;
		}

		for (AbstractShapeCreator creator : creators) {
			if (creator.isSupport(line)) {
				return creator.create(line);
			}
		}

		return null;
	}

}
