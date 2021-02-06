import { shallowMount } from '@vue/test-utils'
import Munros from '@/components/Munros.vue'

describe('Munros.vue', () => {
  it('renders props.msg when passed', () => {
    const msg = 'new message'
    const wrapper = shallowMount(Munros, {
      props: { msg }
    })
    expect(wrapper.text()).toMatch(msg)
  })
})
