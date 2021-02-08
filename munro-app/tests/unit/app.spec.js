import { shallowMount, createLocalVue } from '@vue/test-utils'
import Vuex from 'vuex'
import App from '../../src/App'

const localVue = createLocalVue()

localVue.use(Vuex)

describe('App.vue', () => {
    let actions
    let store

    beforeEach(() => {
        actions = {
            loadRowDataAction: jest.fn(),
            setSearchDataAction: jest.fn()
        }
        store = new Vuex.Store({
            actions
        })
    })

    it('dispatches "actionInput" when input event value is "input"', () => {
        const wrapper = shallowMount(App, { store, localVue })
        wrapper.find('button').trigger('click')
        expect(actions.setSearchDataAction).toHaveBeenCalled()
    })

})