package br.com.pokemon.mediators;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

/**
 * Class responsible for determine the type of Pokemon will be load
 * @author wescley.sousa
 * @since 30 de mar de 2022
 */
@Component
public class PokemonTypeMediator {

	static Map<String, Map<Integer, Integer>> pokemonTypes = new LinkedHashMap<>();
	
	static {
		pokemonTypes.put("ice", Map.of(Integer.MIN_VALUE-1, 5));
		pokemonTypes.put("water", Map.of(5, 10));
		pokemonTypes.put("grass", Map.of(10,15));
		pokemonTypes.put("ground", Map.of(15, 21));
		pokemonTypes.put("bug", Map.of(21, 27));
		pokemonTypes.put("rock", Map.of(27, 33));
		pokemonTypes.put("fire", Map.of(33, Integer.MAX_VALUE));		
	}
	
	/**
	 * Method responsible for determine the Pokemon type by the City Temperature
	 * @param temperature
	 * @return
	 */
	public String getPokemonTypeByTemperature(Double temperature) {
		Map<String, Map<Integer, Integer>> filteredMap = pokemonTypes.entrySet()
			.stream()
			.filter(x-> 
				x.getValue().equals(
					filterPokemonTypeByTemperature(
						x.getValue(), 
						(key, value)->temperature >= key && temperature < value
					)
				)
			)
			.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
		return (String) filteredMap.keySet().toArray()[0];
	}
	
	/**
	 * Functional method responsible for get the map key by temperature
	 * @param <K>
	 * @param <V>
	 * @param map
	 * @param predicate
	 * @return
	 */
	static <K, V> Map<K, V> filterPokemonTypeByTemperature(Map<K, V> map, BiPredicate<K, V> predicate) {
	    return map.entrySet()
				.stream()
				.filter(t-> predicate.test(t.getKey(), t.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
	}
	
}
