public class GrupoAlumnos {
    private String nombre;
    private ListaCalificada listaAlumnos;


    public GrupoAlumnos(String nombre) {
        this.nombre = nombre;
        listaAlumnos = new ListaCalificada();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevoAlumno(Alumno alumno) {
        listaAlumnos.insertar(alumno);
    }

    public int getNumAlumnos() {
        return listaAlumnos.getNumElementos();
    }

    public Alumno getAlumno(int matricula){
        return listaAlumnos.getElemento(matricula);
    }

    public double porcentajeAprobados(String nombreAsignatura){
        int total = 0, aprobados = 0;
        IteradorC itc = listaAlumnos.getIterador();
        while(itc.hasNext()) {
            if(itc.next().estaAprobado(nombreAsignatura)){
                aprobados++;
            }
            total++;
        }
        return ((double)aprobados) / total * 100;
    }
}