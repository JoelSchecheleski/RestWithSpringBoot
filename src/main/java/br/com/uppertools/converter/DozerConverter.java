package br.com.uppertools.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

public class DozerConverter {

	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

	/**
	 * Convert object origin to object destination
	 * 
	 * @param <O>         Origin
	 * @param <D>         Destination
	 * @param origin      Object origin
	 * @param destination Object destination
	 * @return Return object
	 */
	public static <O, D> D parserObject(O origin, Class<D> destination) {
		return mapper.map(origin, destination);
	}

	/**
	 * Convert list origin to list destination
	 * 
	 * @param <O>         Origin
	 * @param <D>         destination
	 * @param origin      List Origin
	 * @param destination List Destination
	 * @return Return list of destination objects
	 */
	public static <O, D> List<D> parserListObjects(List<O> origin, Class<D> destination) {
		List<D> destinationObjects = new ArrayList<D>();
		for (Object o : origin) {
			destinationObjects.add(mapper.map(o, destination));
		}
		return destinationObjects;
	}
}
