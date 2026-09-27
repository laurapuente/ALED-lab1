package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {
	
	private int[] validChannels;

	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	public FilterExtractChannels(int[] validChannels) {//Cuando esté creando un objeto de la clase FilterExtractChannels tengo que pasar un array de números enteros
		this.validChannels = validChannels;//validChannels es un array que contiene los índices que indican los canales que extraeremos del arraylist original
		
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] measurements = eeg.getMeasurements();
		Measurement[] filteredMeasurements = new Measurement[measurements.length];//Creo un array de medidas que se llama filteredMeasurements del mismo tamaño que el array con las medidas extraídas
		
		for(int i=0; i<measurements.length; i++) {
			float[] channels = new float[validChannels.length];
			int k=0;
			for(int channel: validChannels)
				channels[k++]=measurements[i].getChannel(channel);
			filteredMeasurements[i] = new Measurement(channels);
		}
		
		return new EEGModel(filteredMeasurements);
	}

}
