package com.exact.buzon.dao;

import com.exact.buzon.entity.Buzon;

public interface IBuzonDAO {
	
	Iterable<Buzon> buscarBuzon(String texto);

}
