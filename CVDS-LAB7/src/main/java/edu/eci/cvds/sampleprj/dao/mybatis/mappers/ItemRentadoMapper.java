package edu.eci.cvds.sampleprj.dao.mybatis.mappers;

import java.util.Date;
import java.util.List;

import edu.eci.cvds.samples.entities.ItemRentado;
import edu.eci.cvds.samples.entities.TipoItem;

public interface ItemRentadoMapper {
	
	public List<ItemRentado> consultarItemRentado();
	
	public TipoItem getItemRentado(int id);
    
    public void addItemRentado(int cliid,int itemid,Date fechaini,Date fechafin);
}
