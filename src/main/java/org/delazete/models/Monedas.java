package org.delazete.models;

import java.util.Map;

public record Monedas(String base_code, Map conversion_rates) {
}
