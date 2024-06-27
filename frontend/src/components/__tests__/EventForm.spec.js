import {describe, expect, it} from 'vitest'

import {mount} from '@vue/test-utils'
import EventForm from "@/components/EventForm.vue";

describe('EventForm', () => {
    const wrapper = mount(EventForm)
    it('renders properly', () => {
        expect(wrapper.get("#nameHelp").text()).toContain('Veuillez saisir un nom descriptif de 32 caractères ou moins.')
    })
    it('display no error message if no errors are presents ', () => {
        expect(wrapper.find("#error-wrapper").exists()).toBe(false);
    })
    it('display error message if errors are presents', async () => {
        await wrapper.get("#name").setValue("Name");
        await wrapper.get("#description").setValue("Description");
        await wrapper.get("#beginTime").setValue("2023-01-01T12:00");
        await wrapper.get("#endTime").setValue("2022-01-01T12:00");
        await wrapper.get("#submit-button").trigger('click');
        expect(wrapper.find("#error-wrapper").exists()).toBe(true);
        expect(wrapper.find("#error-list:first-child").text()).toBe("La date de début doit précéder la date de fin.");
    })
})