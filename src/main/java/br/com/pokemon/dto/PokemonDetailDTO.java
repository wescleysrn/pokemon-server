package br.com.pokemon.dto;

import java.io.Serializable;

public class PokemonDetailDTO implements Serializable {

	private static final long serialVersionUID = 7617007943927870190L;

	private Integer id;
	
	private String name;
	
	private SpritesI sprites;
	
	static class SpritesI {
		
		private OtherI other;
		
		static class OtherI {
			
			private HomeI home;
			
			static class HomeI {
				
				private String front_default;

				public String getFront_default() {
					return front_default;
				}

				public void setFront_default(String front_default) {
					this.front_default = front_default;
				}
				
			}

			public HomeI getHome() {
				return home;
			}

			public void setHome(HomeI home) {
				this.home = home;
			}
			
		}

		public OtherI getOther() {
			return other;
		}

		public void setOther(OtherI other) {
			this.other = other;
		}
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public SpritesI getSprites() {
		return sprites;
	}

	public void setSprites(SpritesI sprites) {
		this.sprites = sprites;
	}
	
}
