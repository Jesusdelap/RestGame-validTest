package com.rest.demo.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

public enum Genre{
	PLATAFORMAS(),
	FPS(),
	TPS(),
	PUZLE(),
	MOBA(),
	MULTIJUGADOR();

	

}
