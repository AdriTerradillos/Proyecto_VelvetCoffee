package com.proyecto.velvetCoffee.repository;

import com.proyecto.velvetCoffee.model.Coffee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;


/**
 * --PAUTAS--
 * 1º) anotamos clase con @Repository y damos un nombre con @Qualifier (opcional)
 * 2º) declaramos atributo 'JdbcTemplate' e inyectamos por constructor
 * 3º) implementamos métodos del repositorio 'CafeRepository'
 * 4º) creamos un RowMaper para mapear filas SQL a objetos 'Cafe'
 * 5º) gestionamos paginación usando 'Paggeable' y 'PageImpl'
 */


// 1º)
@Repository("jdbcCafeRepository")
public class JDBCCafeRepository implements RepositoryCoffee {

    // 2º)
    private final JdbcTemplate jdbcTemplate;

    public JDBCCafeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    // 3º)
    @Override
    public Optional<Coffee> save(Coffee cafe) {

        // Generamos un ID único en la aplicación (aunque no es lo ideal en muchos casos)
        Long generatedId = System.currentTimeMillis(); // O puedes usar UUID.randomUUID().toString()

        String sql = "INSERT INTO cafe (id, nombre, paisOrigen, region, altitud, variedad, descripcion, " +
                "formato, codigoBarras, precioUnidad, peso_Unidad, fechaCaducidad, stockDisponible, estadoActual, " +
                "isEnOferta, tipoMoneda, aroma, sensacionPaladar, dulzor, acidez, sabor, puntajeEspecializado, perfilSensorial, " +
                "gradoTostado, certificacion, almacenamientoRecomendado, metodoPreparacionSugerido) VALUES (?, ?, ?, ?, ? ,? ,? ,?, ?, ?," +
                "?, ?, ?, ?, ? ,? ,? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        // Ejecutamos la inserción en la base de datos
        jdbcTemplate.update(sql, generatedId,
                cafe.getNombre(), cafe.getPaisOrigen(), cafe.getRegion(), cafe.getAltitud(), cafe.getVariedad(), cafe.getDescripcion(),
                cafe.getFormato(), cafe.getCodigoBarras(), cafe.getPrecioUnidad(), cafe.getPeso_Unidad(), cafe.getFechaCaducidad(),
                cafe.getStockDisponible(), cafe.isEstadoActual(), cafe.isEnOferta(), cafe.getTipoMoneda(), cafe.getAroma(),
                // los List<> se escriben de esta forma en código
                String.join(",", cafe.getSensacionPaladar()),
                String.join(",", cafe.getDulzor()),
                String.join(",", cafe.getAcidez()),
                String.join(",", cafe.getSabor()),
                cafe.getPuntajeEspecializado(), cafe.getPerfilSensorial(), cafe.getGradoTostado(), cafe.getCertificacion(),
                cafe.getAlmacenamientoRecomendado(), cafe.getMetodoPreparacionSugerido());


        // Asignamos el ID generado al objeto
        cafe.setId(generatedId);
        return Optional.of(cafe);
    }


    @Override
    public void deleteById(Long id) {
        String sql = "DELETE FROM cafe WHERE id = ?";

        // Ejecutamos la eliminación de la base de datos
        jdbcTemplate.update(sql, id);
    }


    public Optional<Coffee> findById(Long id) {
        String sql = "SELECT * FROM cafe WHERE id = ?";

        try {
            Coffee cafe = jdbcTemplate.queryForObject(sql, getCafeRowMapper(), id);
            return Optional.ofNullable(cafe);

        } catch (Exception e) {
            return Optional.empty();
        }
    }

    @Override
    public Iterable<Coffee> findAll() {
        return null;
    }


    @Override
    public Page<Coffee> findAll(Pageable pageable) {
        String sql = "SELECT * FROM cafe LIMIT ? OFFSET ?";
        int limit = pageable.getPageSize();
        int offset = pageable.getPageNumber() * limit;

        List<Coffee> cafes = jdbcTemplate.query(sql, getCafeRowMapper(), limit, offset);
        return new PageImpl<>(cafes, pageable, count());
    }


    private long count() {
        String sql = "SELECT COUNT(*) FROM cafe";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }


    private RowMapper<Coffee> getCafeRowMapper() {
        return (rs, rowNum) -> new Coffee(

                rs.getLong("id"),
                rs.getString("nombre"),
                rs.getString("paisOrigen"),
                rs.getString("region"),
                rs.getInt("altitud"),
                rs.getString("variedad"),
                rs.getString("descripcion"),
                rs.getString("formato"),
                rs.getString("codigoBarras"),
                rs.getDouble("precioUnidad"),
                rs.getDouble("peso_Unidad"),
                rs.getDate("fechaCaducidad"),
                rs.getInt("stockDisponible"),
                rs.getBoolean("estadoActual"),
                rs.getBoolean("isEnOferta"),
                rs.getString("tipoMoneda"),
                rs.getString("aroma"),
                // los List<> se escriben de esta forma en código
                List.of(rs.getString("sensacionPaladar").split(",")),
                List.of(rs.getString("dulzor").split(",")),
                List.of(rs.getString("acidez").split(",")),
                List.of(rs.getString("sabor").split(",")),
                rs.getDouble("puntajeEspecializado"),
                rs.getString("perfilSensorial"),
                rs.getString("gradoTostado"),
                rs.getString("certificacion"),
                rs.getString("almacenamientoRecomendado"),
                rs.getString("metodoPreparacionSugerido")
        );

    }

}





