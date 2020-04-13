public class Alumno {
    private String nombre;
    private int matricula;
    private ListaOrdinal expediente;


    public Alumno(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new ListaOrdinal();
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void nuevaEvaluacion(Evaluacion evaluacion) {
        expediente.insertar(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterador it = expediente.getIterador();
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public ListaOrdinal asignaturasAprobadas() {
        ListaOrdinal aprobadas = new ListaOrdinal();
        Iterador it = expediente.getIterador();
        while(it.hasNext()) {
            Evaluacion evaluacion = it.next();
            if(evaluacion.getNota() >= 5) {
                aprobadas.insertar(evaluacion);
            }
        }
        return aprobadas;
    }

    public double mediaAprobadas() {
        double media = 0.0;
        ListaOrdinal aprobadas = this.asignaturasAprobadas();
        Iterador it = aprobadas.getIterador();

        while(it.hasNext()) {
            Evaluacion aux = it.next();
            media += aux.getNota();
        }

        media = media / aprobadas.getNumElementos();

        return media;
    }

    public int getNumAprobadas() {
        ListaOrdinal aprobadas = this.asignaturasAprobadas();
        return aprobadas.getNumElementos();
    }

    public void mostrar() {
        System.out.println(this.getNombre() + ". Matricula: " + this.getMatricula());
        if(!expediente.vacia()) {
            Iterador it = expediente.getIterador();
            while(it.hasNext()) {
                it.next().mostrar();
            }
            System.out.println(expediente.getNumElementos() + " evaluaciones y " + this.asignaturasAprobadas().getNumElementos() +
                    " asignaturas aprobadas con calificacion media " + this.mediaAprobadas());
        }else{
            System.out.println("No ha realizado ninguna evaluación");
        }
        System.out.println("---------------------------------");
    }

}

