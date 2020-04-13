public class Pruebas {

    public static void main(String[] args) {
        //TODO Completar el main
        Evaluacion ev1 = new Evaluacion("ED","Junio 19", 4.5);
        Evaluacion ev2 = new Evaluacion("ED", "Julio 19", -1);
        Evaluacion ev3 = new Evaluacion("ED","Julio 20", 7.4);
        Evaluacion ev4 = new Evaluacion("Algebra","Junio 18", 6.4);

        //2.2   declaramos una lista de Evaluaciones e insertamos 4
        ListaOrdinal listaOrdinalEvaluaciones = new ListaOrdinal();
        listaOrdinalEvaluaciones.insertar(ev1);
        listaOrdinalEvaluaciones.insertar(ev2);
        listaOrdinalEvaluaciones.insertar(ev3);
        listaOrdinalEvaluaciones.insertar(ev4);

        Iterador it = listaOrdinalEvaluaciones.getIterador();
        System.out.println("------------ EVALUACIONES EN LA LISTA -----------");
        while(it.hasNext()){
            it.next().mostrar();
        }

        //2.3
        System.out.println("-------------------------------");
        System.out.println("Numero de convocatorias de ED: " + listaOrdinalEvaluaciones.numConvocatorias("ED"));
        System.out.println("Numero de convocatorias de Algebra: " + listaOrdinalEvaluaciones.numConvocatorias("Algebra"));
        System.out.println("Numero de convocatorias de Fundamentos de Programacion: " + listaOrdinalEvaluaciones.numConvocatorias("Fundamentos de Programacion"));

        //3.5
        Alumno felipe = new Alumno("Felipe García Gómez", 1253);
        Alumno alicia = new Alumno("Alicia Blázquez Martín", 5622);
        felipe.nuevaEvaluacion(ev1);
        felipe.nuevaEvaluacion(ev2);
        felipe.nuevaEvaluacion(ev3);
        felipe.nuevaEvaluacion(ev4);
        ListaOrdinal aprobadasfelipe = felipe.asignaturasAprobadas();
        it = aprobadasfelipe.getIterador();
        System.out.println("----------- Asignaturas aprobadas por Felipe García Gómez ----------");
        while(it.hasNext()) {
            it.next().mostrar();
        }

        ListaOrdinal aprobadasalicia = alicia.asignaturasAprobadas();
        System.out.println("----------- Asignaturas aprobadas por Alicia Blázquez Martín ----------");
        it = aprobadasalicia.getIterador();
        while(it.hasNext()) {
            it.next().mostrar();
        }
        System.out.println("----------- MOSTRAR LOS ALUMNOS ------------");
        felipe.mostrar();
        alicia.mostrar();

        //3.6
        AlumnoBib eduardo = new AlumnoBib("Eduardo Parra Martín", 8765);
        AlumnoBib sonia = new AlumnoBib("Sonia Torres Pardo", 2345);
        eduardo.nuevaEvaluacion(ev1);
        eduardo.nuevaEvaluacion(ev2);
        eduardo.nuevaEvaluacion(ev3);
        eduardo.nuevaEvaluacion(ev4);
        System.out.println("----------- MOSTRAR LOS ALUMNOS BIBLIOTECA ------------");
        eduardo.mostrar();
        sonia.mostrar();

        // TODO empezar con la lista calificada
        //4.1
        Alumno pedro = new Alumno("Pedro Jiménez del Pozo", 8510);
        Evaluacion ev5 = new Evaluacion("Fundamentos de Programación","Enero 19", 8.8);
        pedro.nuevaEvaluacion(ev5);
        ListaCalificada listaCalificadaAlumnos = new ListaCalificada();
        listaCalificadaAlumnos.insertar(pedro);
        listaCalificadaAlumnos.insertar(felipe);
        listaCalificadaAlumnos.insertar(alicia);
        IteradorC itc = listaCalificadaAlumnos.getIterador();
        System.out.println("------------ ALUMNOS EN LA LISTA -------------");
        while(itc.hasNext()) {
            itc.next().mostrar();
        }

        //4.2.3 //TODO hacer todas las pruebas de 4.2.3
        System.out.println("---------- Borramos las claves menores a 6000------------");
        listaCalificadaAlumnos.borrarMenores(6000);
        while(itc.hasNext()) {
            itc.next().mostrar();
        }
        System.out.println("---------- Borramos las claves menores a 9000------------");
        listaCalificadaAlumnos.borrarMenores(9000);
        while(itc.hasNext()) {
            itc.next().mostrar();
        }
        System.out.println("----- Metemos todos los alumnos y borramos las claves mayores a 7000 ------");
        listaCalificadaAlumnos.insertar(pedro);
        listaCalificadaAlumnos.insertar(felipe);
        listaCalificadaAlumnos.insertar(alicia);
        listaCalificadaAlumnos.borrarMayores(7000);
        while(itc.hasNext()) {
            it.next().mostrar();
        }
        System.out.println("------------ Borramos las claves mayores a 1000 -----------");
        listaCalificadaAlumnos.borrarMayores(1000);
        while(it.hasNext()) {
            it.next().mostrar();
        }

        //5.5
        GrupoAlumnos grupoAlumnos = new GrupoAlumnos("GX11");
        grupoAlumnos.nuevoAlumno(felipe);
        grupoAlumnos.nuevoAlumno(alicia);
        grupoAlumnos.nuevoAlumno(pedro);
        System.out.println("------------ CREADO EL GRUPO GX11------------");
        System.out.println("El grupo " + grupoAlumnos.getNombre() + " tiene " + grupoAlumnos.getNumAlumnos() + " alumnos.");
        System.out.println("------------ Grupo GX11. Alumno con matrícula 8510 ------------");
        grupoAlumnos.getAlumno(8510).mostrar();
        System.out.println("El porcentaje de aprobados en ED del grupo " + grupoAlumnos.getNombre() + ":" + grupoAlumnos.porcentajeAprobados("ED"));
    }

}