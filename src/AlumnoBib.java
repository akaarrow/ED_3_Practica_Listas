import java.util.Iterator;
import java.util.LinkedList;

public class AlumnoBib {
    private String nombre;
    private int matricula;
    private LinkedList<Evaluacion> expediente;


    public AlumnoBib(String nombre, int matricula) {
        this.nombre = nombre;
        this.matricula = matricula;
        expediente = new LinkedList<Evaluacion>();
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
        expediente.add(evaluacion);
    }

    public boolean estaAprobado(String nombreAsig) {
        boolean aprobado = false;
        Iterator<Evaluacion> it = expediente.iterator() ;
        while (it.hasNext() && !aprobado) {
            Evaluacion evaluacion = it.next();
            if (evaluacion.getNombreAsignatura().equals(nombreAsig) &&
                    evaluacion.getNota() >= 5.0) {
                aprobado = true;
            }
        }
        return aprobado;
    }

    public LinkedList<Evaluacion> asignaturasAprobadas() {
        LinkedList<Evaluacion> aprobadas = new LinkedList<Evaluacion>();
        Iterator<Evaluacion> it = expediente.iterator();
        while(it.hasNext()) {
            Evaluacion evaluacion = it.next();
            if(evaluacion.getNota() >= 5) {  //TODO implementar usando el metodo de arriba //(evaluacion.getNota() >= 5) esta bien
                aprobadas.add(evaluacion);
            }
        }
        return aprobadas;
    }

    public double mediaAprobadas() {
        double media = 0.0;
        LinkedList<Evaluacion> aprobadas = this.asignaturasAprobadas();
        Iterator<Evaluacion> it = aprobadas.iterator();

        while(it.hasNext()) {
            Evaluacion aux = it.next();
            media += aux.getNota();
        }

        media = media / aprobadas.size();

        return media;
    }

    public int getNumAprobadas() {
        LinkedList<Evaluacion> aprobadas = this.asignaturasAprobadas();
        return aprobadas.size();
    }

    public void mostrar() {
        System.out.println(this.getNombre() + ". Matricula: " + this.getMatricula());
        if(!expediente.isEmpty()) {
            Iterator<Evaluacion> it = expediente.iterator();
            while(it.hasNext()) {
                it.next().mostrar();
            }
            System.out.println(expediente.size() + " evaluaciones y " + this.asignaturasAprobadas().size() +
                    " asignaturas aprobadas con calificacion media " + this.mediaAprobadas());
        }else{
            System.out.println("No ha realizado ninguna evaluación");
        }
        System.out.println("---------------------------------");
    }

}
