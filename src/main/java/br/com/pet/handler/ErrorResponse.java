package br.com.pet.handler;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.GsonBuilder;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({ "erroCode", "error", "errorDescription" })
public class ErrorResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int errorCode;
	private String error;
	private String errorDescription;

	public ErrorResponse() {
		throw new UnsupportedOperationException("Ação não permitida");
	}

	public ErrorResponse(final String errorDescription, final HttpStatus status) {
		this.errorDescription = errorDescription;
		this.error = status.getReasonPhrase();
		this.errorCode = status.value();
	}

	// region getters and setters
	public final int getErrorCode() {
		return errorCode;
	}

	public final void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public final String getError() {
		return error;
	}

	public final void setError(String error) {
		this.error = error;
	}

	public final String getErrorDescription() {
		return errorDescription;
	}

	public final void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	@Override
	public String toString() {
		return new GsonBuilder().disableHtmlEscaping().setPrettyPrinting().create().toJson(this);
	}
}