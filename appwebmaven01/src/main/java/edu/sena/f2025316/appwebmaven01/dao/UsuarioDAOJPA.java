/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.sena.f2025316.appwebmaven01.dao;

import edu.sena.f2025316.appwebmaven01.dao.def.UsuarioDAO;
import edu.sena.f2025316.appwebmaven01.exeception.ConexionExcpetion;
import edu.sena.f2025316.appwebmaven01.exeception.enums.ConexionExcpetionEnum;
import edu.sena.f2025316.appwebmaven01.filtros.FiltroUsuario;
import edu.sena.f2025316.appwebmaven01.modelo.Usuario;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author ismael
 */
@Stateless
public class UsuarioDAOJPA extends GenericDAO<Usuario, Integer> implements UsuarioDAO {

    public UsuarioDAOJPA() {
        super(Usuario.class);
    }

    @Override
    public Usuario consularPorUsuarioClave(String usuario, String clave) throws ConexionExcpetion {
        try {
            TypedQuery<Usuario> tq = em.createNamedQuery("Usuario.findByUsuarioYClave", classs);
            tq.setParameter("nombreUsuario", usuario);
            tq.setParameter("clave", clave);
            return tq.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new ConexionExcpetion(ConexionExcpetionEnum.ERROR_CONEXION, e);
        }
    }

    @Override
    public List<Usuario> consultarPorFiltro(FiltroUsuario filtro) throws ConexionExcpetion {
        try {
            Map<String, Object> parametros = new HashMap<>();
            String query = construirQueryFiltro(parametros,filtro);
            
            TypedQuery<Usuario> tq = em.createQuery(query, classs);
            parametros.forEach((k, v) -> tq.setParameter(k, v));
            return tq.getResultList();
        } catch (Exception e) {
            throw new ConexionExcpetion(ConexionExcpetionEnum.ERROR_CONEXION, e);
        }
    }

    private String construirQueryFiltro(Map<String, Object> parametros, FiltroUsuario filtro) {
        StringBuilder sbQuery = new StringBuilder("SELECT u FROM Usuario u WHERE 1=1 ");
        if (Objects.nonNull(filtro.getTipoDocumentoId())) {
            sbQuery.append(" AND u.tipoDocumento.id = :tipoDocumentoId");
            parametros.put("tipoDocumentoId", filtro.getTipoDocumentoId());
        }
        if (Objects.nonNull(filtro.getNumeroDocumento()) && !filtro.getNumeroDocumento().isEmpty()) {
            sbQuery.append(" AND u.numeroDocumento = :numeroDocumento");
            parametros.put("numeroDocumento", filtro.getNumeroDocumento());
        }
        if (Objects.nonNull(filtro.getNombres()) && !filtro.getNombres().isEmpty()) {
            sbQuery.append(" AND u.nombres LIKE :nombres");
            parametros.put("nombres", "%" + filtro.getNombres() +"%");
        }
        if (Objects.nonNull(filtro.getApellidos()) && !filtro.getApellidos().isEmpty()) {
            sbQuery.append(" AND u.apellidos = :apellidos");
            parametros.put("apellidos", filtro.getApellidos());
        }
        return sbQuery.toString();
    }

}
