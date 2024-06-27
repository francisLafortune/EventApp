import {map} from '../EventMapper.js'
import {describe, expect, it} from 'vitest'

const eventForm = {
    name: "Event name",
    description: "Event description",
    beginTime: "2023-01-01T12:00",
    endTime: "2023-01-01T13:00"
}

describe('EventMapper', () => {
    it('maps properly and convert date to timestamps', () => {
        const eventRequest = map(eventForm);
        expect(eventRequest).toEqual({
            name: "Event name",
            description: "Event description",
            beginTimestamp: 1672592400,
            endTimestamp: 1672596000
        })
    })
})