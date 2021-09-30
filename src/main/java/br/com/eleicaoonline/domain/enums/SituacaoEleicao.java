package br.com.eleicaoonline.domain.enums;

public enum SituacaoEleicao {

	CADASTRADA(0),

	INICIADA(1),

	FINALIZADA(2);

	private int value;

	private SituacaoEleicao(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static SituacaoEleicao fromValue(String text) {
		for (SituacaoEleicao b : SituacaoEleicao.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}

}
