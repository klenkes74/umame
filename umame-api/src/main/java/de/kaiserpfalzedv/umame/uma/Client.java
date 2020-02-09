/*
 * Copyright (c) 2020 Kaiserpfalz EDV-Service, Roland T. Lichti
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package de.kaiserpfalzedv.umame.uma;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.immutables.value.Generated;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * The service handling the user authorization. Often the same service also
 * handles the authentication - without authentication no authorization may take
 * place. By default an OpenID Connect service.
 *
 * @author rlichti
 * @version 1.0.0 2020-02-08
 * @since 1.0.0 2020-02-08
 */
@Generated(from = "_Claim", generator = "Immutables")
@SuppressWarnings({"all"})
@javax.annotation.processing.Generated("org.immutables.processor.ProxyProcessor")
public final class Client implements _Claim {
  private final String name;
  private final String friendlyName;
  private final String claimType;
  private final List<URI> issuer;
  private final List<URI> claimTokenFormat;

  private Client(Client.Builder builder) {
    this.name = builder.name;
    this.friendlyName = builder.friendlyName;
    this.claimType = builder.claimType;
    this.issuer = createUnmodifiableList(true, builder.issuer);
    this.claimTokenFormat = builder.claimTokenFormatIsSet()
            ? createUnmodifiableList(true, builder.claimTokenFormat)
            : createUnmodifiableList(false, createSafeList(_Claim.super.getClaimTokenFormat(), true, false));
  }

  private Client(
          String name,
          String friendlyName,
          String claimType,
          List<URI> issuer,
          List<URI> claimTokenFormat) {
    this.name = name;
    this.friendlyName = friendlyName;
    this.claimType = claimType;
    this.issuer = issuer;
    this.claimTokenFormat = claimTokenFormat;
  }

  /**
   * @return The value of the {@code name} attribute
   */
  @JsonProperty("name")
  @Override
  public String getName() {
    return name;
  }

  /**
   * @return The value of the {@code friendlyName} attribute
   */
  @JsonProperty("friendly_name")
  @Override
  public String getFriendlyName() {
    return friendlyName;
  }

  /**
   * @return The value of the {@code claimType} attribute
   */
  @JsonProperty("claim_type")
  @Override
  public String getClaimType() {
    return claimType;
  }

  /**
   * @return The value of the {@code issuer} attribute
   */
  @JsonProperty("issuer")
  @Override
  public List<URI> getIssuer() {
    return issuer;
  }

  /**
   * @return The value of the {@code claimTokenFormat} attribute
   */
  @JsonProperty("claim_token_format")
  @Override
  public List<URI> getClaimTokenFormat() {
    return claimTokenFormat;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link _Claim#getName() name} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   *
   * @param value A new value for name
   * @return A modified copy of the {@code this} object
   */
  public final Client withName(String value) {
    String newValue = Objects.requireNonNull(value, "name");
    if (this.name.equals(newValue)) return this;
    return new Client(newValue, this.friendlyName, this.claimType, this.issuer, this.claimTokenFormat);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link _Claim#getFriendlyName() friendlyName} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   *
   * @param value A new value for friendlyName
   * @return A modified copy of the {@code this} object
   */
  public final Client withFriendlyName(String value) {
    String newValue = Objects.requireNonNull(value, "friendlyName");
    if (this.friendlyName.equals(newValue)) return this;
    return new Client(this.name, newValue, this.claimType, this.issuer, this.claimTokenFormat);
  }

  /**
   * Copy the current immutable object by setting a value for the {@link _Claim#getClaimType() claimType} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   *
   * @param value A new value for claimType
   * @return A modified copy of the {@code this} object
   */
  public final Client withClaimType(String value) {
    String newValue = Objects.requireNonNull(value, "claimType");
    if (this.claimType.equals(newValue)) return this;
    return new Client(this.name, this.friendlyName, newValue, this.issuer, this.claimTokenFormat);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link _Claim#getIssuer() issuer}.
   *
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Client withIssuer(URI... elements) {
    List<URI> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new Client(this.name, this.friendlyName, this.claimType, newValue, this.claimTokenFormat);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link _Claim#getIssuer() issuer}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   *
   * @param elements An iterable of issuer elements to set
   * @return A modified copy of {@code this} object
   */
  public final Client withIssuer(Iterable<? extends URI> elements) {
    if (this.issuer == elements) return this;
    List<URI> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new Client(this.name, this.friendlyName, this.claimType, newValue, this.claimTokenFormat);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link _Claim#getClaimTokenFormat() claimTokenFormat}.
   *
   * @param elements The elements to set
   * @return A modified copy of {@code this} object
   */
  public final Client withClaimTokenFormat(URI... elements) {
    List<URI> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
    return new Client(this.name, this.friendlyName, this.claimType, this.issuer, newValue);
  }

  /**
   * Copy the current immutable object with elements that replace the content of {@link _Claim#getClaimTokenFormat() claimTokenFormat}.
   * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
   *
   * @param elements An iterable of claimTokenFormat elements to set
   * @return A modified copy of {@code this} object
   */
  public final Client withClaimTokenFormat(Iterable<? extends URI> elements) {
    if (this.claimTokenFormat == elements) return this;
    List<URI> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
    return new Client(this.name, this.friendlyName, this.claimType, this.issuer, newValue);
  }

  /**
   * This instance is equal to all instances of {@code Claim} that have equal attribute values.
   *
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof Client
            && equalTo((Client) another);
  }

  private boolean equalTo(Client another) {
    return name.equals(another.name)
            && friendlyName.equals(another.friendlyName)
            && claimType.equals(another.claimType)
            && issuer.equals(another.issuer)
            && claimTokenFormat.equals(another.claimTokenFormat);
  }

  /**
   * Computes a hash code from attributes: {@code name}, {@code friendlyName}, {@code claimType}, {@code issuer}, {@code claimTokenFormat}.
   *
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 5381;
    h += (h << 5) + name.hashCode();
    h += (h << 5) + friendlyName.hashCode();
    h += (h << 5) + claimType.hashCode();
    h += (h << 5) + issuer.hashCode();
    h += (h << 5) + claimTokenFormat.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code Claim} with attribute values.
   *
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "Claim{"
            + "name=" + name
            + ", friendlyName=" + friendlyName
            + ", claimType=" + claimType
            + ", issuer=" + issuer
            + ", claimTokenFormat=" + claimTokenFormat
            + "}";
  }

  /**
   * Creates an immutable copy of a {@link _Claim} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   *
   * @param instance The instance to copy
   * @return A copied immutable Claim instance
   */
  public static Client copyOf(_Claim instance) {
    if (instance instanceof Client) {
      return (Client) instance;
    }
    return Client.builder()
            .from(instance)
            .build();
  }

  /**
   * Creates a builder for {@link Client Claim}.
   * <pre>
   * Claim.builder()
   *    .name(String) // required {@link _Claim#getName() name}
   *    .friendlyName(String) // required {@link _Claim#getFriendlyName() friendlyName}
   *    .claimType(String) // required {@link _Claim#getClaimType() claimType}
   *    .addIssuer|addAllIssuer(java.net.URI) // {@link _Claim#getIssuer() issuer} elements
   *    .addClaimTokenFormat|addAllClaimTokenFormat(java.net.URI) // {@link _Claim#getClaimTokenFormat() claimTokenFormat} elements
   *    .build();
   * </pre>
   *
   * @return A new Claim builder
   */
  public static Client.Builder builder() {
    return new Client.Builder();
  }

  /**
   * Builds instances of type {@link Client Claim}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  @Generated(from = "_Claim", generator = "Immutables")
  public static final class Builder {
    private static final long INIT_BIT_NAME = 0x1L;
    private static final long INIT_BIT_FRIENDLY_NAME = 0x2L;
    private static final long INIT_BIT_CLAIM_TYPE = 0x4L;
    private static final long OPT_BIT_CLAIM_TOKEN_FORMAT = 0x1L;
    private long initBits = 0x7L;
    private long optBits;

    private String name;
    private String friendlyName;
    private String claimType;
    private List<URI> issuer = new ArrayList<URI>();
    private List<URI> claimTokenFormat = new ArrayList<URI>();

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code MutableClaim} instance.
     *
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(MutableClaim instance) {
      Objects.requireNonNull(instance, "instance");
      if (instance.nameIsSet()) {
        name(instance.getName());
      }
      if (instance.friendlyNameIsSet()) {
        friendlyName(instance.getFriendlyName());
      }
      if (instance.claimTypeIsSet()) {
        claimType(instance.getClaimType());
      }
      addAllIssuer(instance.getIssuer());
      addAllClaimTokenFormat(instance.getClaimTokenFormat());
      return this;
    }

    /**
     * Fill a builder with attribute values from the provided {@code _Claim} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * Collection elements and entries will be added, not replaced.
     *
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(_Claim instance) {
      Objects.requireNonNull(instance, "instance");
      if (instance instanceof MutableClaim) {
        return from((MutableClaim) instance);
      }
      name(instance.getName());
      friendlyName(instance.getFriendlyName());
      claimType(instance.getClaimType());
      addAllIssuer(instance.getIssuer());
      addAllClaimTokenFormat(instance.getClaimTokenFormat());
      return this;
    }

    /**
     * Initializes the value for the {@link _Claim#getName() name} attribute.
     *
     * @param name The value for name
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("name")
    public final Builder name(String name) {
      this.name = Objects.requireNonNull(name, "name");
      initBits &= ~INIT_BIT_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link _Claim#getFriendlyName() friendlyName} attribute.
     *
     * @param friendlyName The value for friendlyName
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("friendly_name")
    public final Builder friendlyName(String friendlyName) {
      this.friendlyName = Objects.requireNonNull(friendlyName, "friendlyName");
      initBits &= ~INIT_BIT_FRIENDLY_NAME;
      return this;
    }

    /**
     * Initializes the value for the {@link _Claim#getClaimType() claimType} attribute.
     *
     * @param claimType The value for claimType
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("claim_type")
    public final Builder claimType(String claimType) {
      this.claimType = Objects.requireNonNull(claimType, "claimType");
      initBits &= ~INIT_BIT_CLAIM_TYPE;
      return this;
    }

    /**
     * Adds one element to {@link _Claim#getIssuer() issuer} list.
     *
     * @param element A issuer element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIssuer(URI element) {
      this.issuer.add(Objects.requireNonNull(element, "issuer element"));
      return this;
    }

    /**
     * Adds elements to {@link _Claim#getIssuer() issuer} list.
     *
     * @param elements An array of issuer elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addIssuer(URI... elements) {
      for (URI element : elements) {
        this.issuer.add(Objects.requireNonNull(element, "issuer element"));
      }
      return this;
    }


    /**
     * Sets or replaces all elements for {@link _Claim#getIssuer() issuer} list.
     *
     * @param elements An iterable of issuer elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("issuer")
    public final Builder issuer(Iterable<? extends URI> elements) {
      this.issuer.clear();
      return addAllIssuer(elements);
    }

    /**
     * Adds elements to {@link _Claim#getIssuer() issuer} list.
     *
     * @param elements An iterable of issuer elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllIssuer(Iterable<? extends URI> elements) {
      for (URI element : elements) {
        this.issuer.add(Objects.requireNonNull(element, "issuer element"));
      }
      return this;
    }

    /**
     * Adds one element to {@link _Claim#getClaimTokenFormat() claimTokenFormat} list.
     *
     * @param element A claimTokenFormat element
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addClaimTokenFormat(URI element) {
      this.claimTokenFormat.add(Objects.requireNonNull(element, "claimTokenFormat element"));
      optBits |= OPT_BIT_CLAIM_TOKEN_FORMAT;
      return this;
    }

    /**
     * Adds elements to {@link _Claim#getClaimTokenFormat() claimTokenFormat} list.
     *
     * @param elements An array of claimTokenFormat elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addClaimTokenFormat(URI... elements) {
      for (URI element : elements) {
        this.claimTokenFormat.add(Objects.requireNonNull(element, "claimTokenFormat element"));
      }
      optBits |= OPT_BIT_CLAIM_TOKEN_FORMAT;
      return this;
    }


    /**
     * Sets or replaces all elements for {@link _Claim#getClaimTokenFormat() claimTokenFormat} list.
     *
     * @param elements An iterable of claimTokenFormat elements
     * @return {@code this} builder for use in a chained invocation
     */
    @JsonProperty("claim_token_format")
    public final Builder claimTokenFormat(Iterable<? extends URI> elements) {
      this.claimTokenFormat.clear();
      return addAllClaimTokenFormat(elements);
    }

    /**
     * Adds elements to {@link _Claim#getClaimTokenFormat() claimTokenFormat} list.
     *
     * @param elements An iterable of claimTokenFormat elements
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder addAllClaimTokenFormat(Iterable<? extends URI> elements) {
      for (URI element : elements) {
        this.claimTokenFormat.add(Objects.requireNonNull(element, "claimTokenFormat element"));
      }
      optBits |= OPT_BIT_CLAIM_TOKEN_FORMAT;
      return this;
    }

    /**
     * Builds a new {@link Client Claim}.
     *
     * @return An immutable instance of Claim
     * @throws IllegalStateException if any required attributes are missing
     */
    public Client build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new Client(this);
    }

    private boolean claimTokenFormatIsSet() {
      return (optBits & OPT_BIT_CLAIM_TOKEN_FORMAT) != 0;
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<>();
      if ((initBits & INIT_BIT_NAME) != 0) attributes.add("name");
      if ((initBits & INIT_BIT_FRIENDLY_NAME) != 0) attributes.add("friendlyName");
      if ((initBits & INIT_BIT_CLAIM_TYPE) != 0) attributes.add("claimType");
      return "Cannot build Claim, some of required attributes are not set " + attributes;
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<>();
    } else {
      list = new ArrayList<>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch (list.size()) {
      case 0:
        return Collections.emptyList();
      case 1:
        return Collections.singletonList(list.get(0));
      default:
        if (clone) {
          return Collections.unmodifiableList(new ArrayList<>(list));
        } else {
          if (list instanceof ArrayList<?>) {
            ((ArrayList<?>) list).trimToSize();
          }
          return Collections.unmodifiableList(list);
        }
    }
  }
}
