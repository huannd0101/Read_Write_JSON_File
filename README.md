# Write and read JSON file

### Add dependence:

<pre>&lt;<span class="pl-ent">dependency</span>&gt;
  &lt;<span class="pl-ent">groupId</span>&gt;com.fasterxml.jackson.core&lt;/<span class="pl-ent">groupId</span>&gt;
  &lt;<span class="pl-ent">artifactId</span>&gt;jackson-databind&lt;/<span class="pl-ent">artifactId</span>&gt;
  &lt;<span class="pl-ent">version</span>&gt;2.10.0&lt;/<span class="pl-ent">version</span>&gt;
&lt;/<span class="pl-ent">dependency</span>&gt;
</pre>

### lưu ý:
- Để ghi read mảng object cần config dòng này: 
mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);