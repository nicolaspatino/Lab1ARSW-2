# Lab1ARSW-2

## Dogs Race case 🚀

### Part I.

_Creation, commissioning and coordination of threads._

* **1.**  _Review the "concurrent cousins" program (in the folder part1), provided in the package edu.eci.arsw.primefinder.
This is a program that calculates the prime numbers between two intervals, distributing their search among independent threads. 
For now, it has a single thread that seeks cousins ​​between 0 and 30,000,000. 
Run it, open the operating system process manager, and verify how many cores are used by it._
* **2.** _Modify the program so that, instead of solving the problem with a single thread, do it with three, where each of these
will make up the first part of the original problem. Check the operation again, and again check the use of the equipment cores._
* **3.** _What you have been asked for is: you must modify the application so that when 5 seconds have elapsed since the execution 
started, all the threads are stopped and the number of primes ​​found so far is displayed. Then, you must wait for the user to press
ENTER to resume their execution._
#
para dar solucion a la primer parte la idea de nuestra solucion consiste en una clase "control" se encarga de crear y dividir la solucion entre los hilos requeridos que seran PrimeFinderThread, tambien alli se definiran  las funcionalidades de pausa y resume para cumplir con los requerimientos de solucion.
#

### Part II
_For this exercise, you will work with a greyhound racing simulator (folder part2), whose graphic representation corresponds to the  figure in the document:_


_In the simulation, all the greyhounds have the same speed (at the programming level), so the winning greyhound will be the one that (for reasons of chance) has been most benefited by the scheduling of the processor (that is, the one with the most cycles CPU has been granted during the race). The application model is  in the figure of the document:_


#
_As you can see, greyhounds are thread objects, and their progress is displayed in the Canodromo class, which is basically a Swing form. All greyhounds (by default, there are 17 greyhounds running on a 100-meter track) share access to an object of type RegistrationLlegada. When a greyhound reaches the goal, it accesses the counter located on said object (whose initial value is 1), and takes that value as its arrival position, and then increases it by 1. The greyhound that manages to take the '1' will be the winner.
When starting the application, there is a first obvious error: the results (total run and number of the winning greyhound) are shown before the end of the race as such. However, once this is corrected, there may be more inconsistencies caused by the presence of race conditions._

### Part III
* **1.**  _Fix the application so that the results notice is shown only when the execution of all the ‘greyhound’ threads is finished._

* **2.** _Once the initial problem has been corrected, run the application several times, and identify the inconsistencies in the results of the same by seeing the ‘ranking’ shown on the console (sometimes valid results could appear, but in other cases such inconsistencies may occur). From this, identify the critical regions of the program._
* **3.** _Use a synchronization mechanism to ensure that these critical regions only access one thread at a time. Verify the results._
* **4.** _Implement the pause and continue functionalities. With these, when "Stop" is clicked, all the threads of the greyhounds should fall asleep, and when "Continue" is clicked they should wake up and continue with the race. Design a solution that allows you to do this using the synchronization mechanisms with the Locks primitives provided by the language (wait and notifyAll)._

#
_el problema de la aplicacion que mostraba el mensaje antes de la finalizacion de la ejecucion se daba que se mostraba debido a que los hilos no estaban bien sincronizados una vez solucionado esto la aparicion del mensaje fue al final de la ejecucion_
#
_las inconsistencias en el proyecto se daban debido a que el programa en algunas ejecuciones mostraba que habian menos galgos compitiendo de los 17_
#
_para poder implementar las funcionalidades de pausa y continuar se identifico que no era suficiente con dormir los hilos correspondientes a los galgos ya que el hilo principal igualemnte seguia ejecutandose, fue necesario agregar una variable booleana a el hilo principa y su metodo get y set, permitiendo asi realizar un llamado a esta y cambiar su valor para poder pausar el hilo principal de ejecucion._
#
#
