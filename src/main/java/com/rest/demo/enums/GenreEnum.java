package com.rest.demo.enums;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public enum GenreEnum{
	PLATAFORMAS(),
	FPS(),
	TPS(),
	PUZLE(),
	MOBA(),
	MULTIJUGADOR();

	

}
