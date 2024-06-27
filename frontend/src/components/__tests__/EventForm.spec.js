import {describe, expect, it} from 'vitest'

import {mount} from '@vue/test-utils'
import EventForm from "@/components/EventForm.vue";

describe('EventForm', () => {
    const wrapper = mount(EventForm)
    it('renders properly', () => {
        expect(wrapper.get("#nameHelp").text()).toContain('Veuillez saisir un nom descriptif de 32 caractères ou moins.')
    })
    it('display no error message if no errors are presents ', () => {
        expect(wrapper.find("#beginTimeHelp").exists()).toBe(false);
    })
    it('display error message if errors are presents', async () => {
        await wrapper.get("#beginTime").setValue("2023-01-01T12:00");
        await wrapper.get("#endTime").setValue("2022-01-01T12:00");
        expect(wrapper.find("#beginTimeHelp").exists()).toBe(true);
        expect(wrapper.find("#beginTimeHelp").text()).toBe("Le début de l'événement doit être avant la fin.");
    })
})