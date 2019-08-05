package rocks.like.shaped.lunchmeup.fetcher

import rocks.like.shaped.lunchmeup.domain.Menu

interface Fetchable {
  fun fetch(): List<Menu>
}