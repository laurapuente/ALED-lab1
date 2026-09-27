package es.upm.aled.lab1.measurements;

/**
 * Interface used to define a filter that can be applied over an EEG model.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public interface Filter {

	/**
	 * Applies the filter over a given EEG model and returns a new one.
	 * 
	 * @param eeg Model to be filtered.
	 * @return Filtered model.
	 */
	EEGModel applyFilter(EEGModel eeg);//una interfaz es solo una lista de métodos que luego va a programar otro. Reciben un electro completo y luego devuelven otro
}
