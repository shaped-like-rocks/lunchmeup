package lunchmeup.fetcher

import lunchmeup.domain.Menu

interface Fetchable {
  fun fetch(): List<Menu>
}