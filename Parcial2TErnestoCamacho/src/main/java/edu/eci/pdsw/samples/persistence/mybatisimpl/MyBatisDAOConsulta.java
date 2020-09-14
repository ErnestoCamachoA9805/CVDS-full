package edu.eci.pdsw.samples.persistence.mybatisimpl;

import com.google.inject.Inject;
import edu.eci.pdsw.samples.entities.Consulta;
import edu.eci.pdsw.samples.entities.Paciente;
import edu.eci.pdsw.samples.entities.TipoIdentificacion;
import edu.eci.pdsw.samples.persistence.DaoConsulta;
import edu.eci.pdsw.samples.persistence.DaoPaciente;
import edu.eci.pdsw.samples.persistence.PersistenceException;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.ConsultaMapper;
import edu.eci.pdsw.samples.persistence.mybatisimpl.mappers.PacienteMapper;
import java.util.List;

public class MyBatisDAOConsulta implements DaoConsulta {

	@Inject 
	ConsultaMapper consultaMapper;
	
	public List<Paciente> consultaEnfermedades() throws PersistenceException {
		try {
			return consultaMapper.consultaEnfermedades();
		}catch(Exception e) {
			throw new PersistenceException("Error al consultar los pacientes con enfermedades contagiosas:"+e.getLocalizedMessage(), e);
		}
	}

}
