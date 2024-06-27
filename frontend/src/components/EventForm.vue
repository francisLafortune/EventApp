<script setup>

import {computed, reactive} from "vue";
import {map} from "@/utils/EventMapper.js";
import {validate} from "@/utils/EventFormValidator.js";

const eventForm = reactive({
  name: '',
  description: '',
  beginTime: '',
  endTime: ''
})

const eventRequest = computed(() => map(eventForm));
const isValid = computed(() => validate(eventForm));


</script>

<template>
  <form>
    <div class="mb-3">
      <label class="form-label" for="name">Nom</label>
      <input id="name" v-model="eventForm.name" class="form-control" maxlength="32" type="text">
      <div id="nameHelp" class="form-text">Veuillez saisir un nom descriptif de 32 caractères ou moins.</div>
    </div>
    <div class="mb-3">
      <label class="form-label" for="description">Description</label>
      <textarea id="description" class="form-control"></textarea>
    </div>
    <div class="mb-3">
      <label class="form-label" for="beginTime">Début</label>
      <input id="beginTime" v-model="eventForm.beginTime" :class="{ 'is-invalid': !isValid }"
             class="form-control" type="datetime-local">
      <div v-if="!isValid" id="beginTimeHelp" class="form-text">Le début de l'événement doit
        être avant la
        fin.
      </div>
    </div>
    <div class="mb-3">
      <label class="form-label" for="endTime">Fin</label>
      <input v-model="eventForm.endTime" :class="{ 'is-invalid': !isValid }" class="form-control"
             type="datetime-local">
      <div v-if="!isValid" id="beginTimeHelp" class="form-text">La fin de l'événement doit
        être après le
        début.
      </div>
    </div>
    <button class="btn btn-primary" type="submit">Envoyer</button>
  </form>
</template>