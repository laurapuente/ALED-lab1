package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified period from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractPeriod implements Filter {
	
	private int min;//Guardar como atributo los datos del constructor
	private int max;

	/**
	 * Builds the Filter from the [min, max] range defining the period that needs to
	 * be extracted. min and max are the indexes of the first and last measurements
	 * of the array obtained by calling the getMeasurements() method of EEGModel,
	 * and represent the starting and ending point of the period to be extracted.
	 * Both indexes are included and max-min must be less than the length of the
	 * Measurements array of the EGG Model.
	 * 
	 * @param min Start of the period to be extracted.
	 * @param max End of the period to be extracted.
	 */
	public FilterExtractPeriod(int min, int max) {//Constructor que recibe los dos números de índice para filtar
		this.min=min;
		this.max=max;	
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {//Método de filtrado, la única manera de que este método acceda a los dstos del constructor es guardándolos como atributo
		Measurement[] measurements = eeg.getMeasurements();//Creo un array de medidas al que llamo measurements e invoco al método getMeasurements del eeg para que me pase sus medidas en forma de array
		
		if(max<measurements.length && min<measurements.length) {
			Measurement[] filteredMeasurements = new Measurement[max-min+1]; //Creo un nuevo array del tamaño tras aplicar el filtro
			
			int k = 0;//Creo una variable que va apuntando a las posiciones del nuevo array filtrado
			for(int i = min; i <=max; i++)
				filteredMeasurements[k++] = measurements[i];//Copia en la posición k-ésima empezando por 0 lo que hay en la posicion i-ésima del array original
			
			return new EEGModel(filteredMeasurements);//Creo un objeto a partir del array creado y eso es lo que devuelvo como resultado
			
		}
		
		return new EEGModel();
	}
}
