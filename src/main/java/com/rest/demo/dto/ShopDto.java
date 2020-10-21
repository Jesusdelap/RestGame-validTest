package com.rest.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ShopDto {
	
	
	private Long idshops;
	@NotNull
	@Size(min=2, max=32)
	private String name;
	@NotNull
	@Size(min=2, max=128)
	private String direccion;

	public ShopDto(Long idshops, @NotNull @Size(min = 2, max = 32) String name,
			@NotNull @Size(min = 2, max = 128) String direccion) {
		super();
		this.idshops = idshops;
		this.name = name;
		this.direccion = direccion;
	}
	public ShopDto( @NotNull @Size(min = 2, max = 32) String name,
			@NotNull @Size(min = 2, max = 128) String direccion) {
		super();
		this.name = name;
		this.direccion = direccion;
	}
	
	public ShopDto() {
		super();
	}

	public Long getIdshops() {
		return idshops;
	}

	public void setIdshops(Long idshops) {
		this.idshops = idshops;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "ShopDto [idshops=" + idshops + ", name=" + name + ", direccion=" + direccion + "]";
	}
	
	
}
